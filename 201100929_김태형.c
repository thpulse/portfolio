#include <openssl/rsa.h>
#include <openssl/pem.h>
#include <openssl/err.h>
#include <openssl/aes.h>
#include <openssl/sha.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#define KEY_LENGTH 2048
#define BUFSIZE 800
#define PUB_EXP 3
#define BYTES_SIZE 1024
#define SHARED_KEY_SIZE 128

struct Format {
	int id;
	unsigned char email[40];
	unsigned char name[30];
	unsigned char pubKeyOfSender[BUFSIZE];
	unsigned char encrypted_MSG[KEY_LENGTH/8];
	unsigned char encrypted_SharedKey[KEY_LENGTH/8];
	unsigned char sign[KEY_LENGTH/8];
};

/* Symmetric Encryption */

unsigned char iv[8] = {0x66, 0x61, 0x63, 0x65, 0x73, 0x65, 0x61, 0x00};
struct ctr_state {
	unsigned char ivec[AES_BLOCK_SIZE];
	unsigned int num;
	unsigned char ecount[AES_BLOCK_SIZE];
};
unsigned char ckey[] = "slrkrkfkgkdhkdld";

AES_KEY key;

int init_ctr(struct ctr_state *state, const unsigned char iv[8]) {
	state->num = 0;
	memset(state->ecount, 0, AES_BLOCK_SIZE);
	memset(state->ivec+8, 0, 8);
	memcpy(state->ivec, iv, 8);
}

void aes_encrypt(unsigned char *indata, unsigned char *outdata, int bytes_read, unsigned char *ckey) {

	int i = 0;
	int mod_len = 0;

	AES_set_encrypt_key(ckey, SHARED_KEY_SIZE, &key);

	if(bytes_read < BYTES_SIZE) {
		struct ctr_state state;
		init_ctr(&state, iv);
		AES_ctr128_encrypt(indata, outdata, bytes_read, &key, state.ivec, state.ecount, &state.num);
		return;
	}

	for(i = BYTES_SIZE; i <= bytes_read; i += BYTES_SIZE) {
		struct ctr_state state;
		init_ctr(&state, iv);
		AES_ctr128_encrypt(indata, outdata, BYTES_SIZE, &key, state.ivec, state.ecount, &state.num);
		indata += BYTES_SIZE;
		outdata += BYTES_SIZE;
	}

	mod_len = bytes_read % BYTES_SIZE;
	if(mod_len != 0) {
		struct ctr_state state;
		init_ctr(&state, iv);
		AES_ctr128_encrypt(indata, outdata, mod_len, &key, state.ivec, state.ecount, &state.num);
	}
}

/* main function */

int main() {
	size_t pri_len, pub_len;
	char *pri_key, *pub_key;
	char *encrypt = NULL;
	char *decrypt = NULL;
	char *err;
	char sha256_str[SHA256_DIGEST_LENGTH];
	unsigned char sign[256];
	unsigned char d_sign[256];
	unsigned char msg[] = {"cjwcjswo"};
	unsigned char *e_msg, *d_msg;
	int n, sign_len, d_sign_len, result, encrypt_len, decrypt_len;
	RSA *recvPubKey, *recvPriKey, *sendPriKey, *sendPubKey;
	struct Format Assignment;
	FILE *recvPubFP, *recvPriFP, *sendPriFP, *sendPubFP, *structFP;
	SHA256_CTX sha256;
	
	memset(sign, 0x00, sizeof(sign));
	memset(d_sign, 0x00, sizeof(d_sign));
	printf("------Assignment 2 Start------\n");

/*------Assignment 2------*/
/* Store id, email, name */
	
	memset(&Assignment, 0, sizeof(Assignment));
	Assignment.id = 201103622;
	strcpy(Assignment.email, "hklk@naver.com");
	strcpy(Assignment.name, "ChoiJinWoo");
	memset(Assignment.pubKeyOfSender, 0, sizeof(Assignment.pubKeyOfSender));
	printf("1.Store Information COMPLETE!\n");

/* Store Sender Public Key */

	if((sendPubFP = fopen("public_201103622.pem", "r")) == NULL) {
		printf("Cannot Open Public Key File.\n");
		exit(1);
	}
	fread(Assignment.pubKeyOfSender, 1, sizeof(Assignment.pubKeyOfSender), sendPubFP);
	fclose(sendPubFP);

/* Shared key encrypt Message and Store */	
	e_msg = malloc(sizeof(msg));
	aes_encrypt(msg, e_msg, 8, ckey);
	strcpy(Assignment.encrypted_MSG, e_msg);
	printf("2.Encrypt Message and Store COMPLETE!\n");

/* Receiver Public Key encrypt Shared Key and Store */
	encrypt = malloc(KEY_LENGTH);
	if((recvPubFP = fopen("public_12.pem", "r")) == NULL) {
		printf("Cannot Open Receiver Public Key File.\n");
		exit(1);
	}
	recvPubKey = PEM_read_RSAPublicKey(recvPubFP, NULL, NULL, NULL);  
	err = malloc(130);
	if((encrypt_len = RSA_public_encrypt(strlen(ckey)+1, ckey, (unsigned char *)encrypt, recvPubKey, RSA_PKCS1_OAEP_PADDING)) == -1) {
		ERR_load_crypto_strings();
		ERR_error_string(ERR_get_error(), err);
		fprintf(stderr, "Error encrypting message: %s\n", err);
		goto free_stuff;
	}
	memcpy(Assignment.encrypted_SharedKey, encrypt, encrypt_len);
	fclose(recvPubFP);
	printf("3.Encrypt Shared Key and Store COMPLETE!\n");

/* Sender's private encrypt struct -> store sign  */

	SHA256_Init(&sha256);
	SHA256_Update(&sha256, &Assignment, sizeof(struct Format));
	SHA256_Final(sha256_str, &sha256);

	if((sendPriFP = fopen("private_201103622.pem", "r")) == NULL) {
		printf("Cannot Open sender Private Key File.\n");
		exit(1);
	}
	sendPriKey = PEM_read_RSAPrivateKey(sendPriFP, NULL, NULL, NULL);

	if((sign_len = RSA_private_encrypt(sizeof(sha256_str), sha256_str, sign, sendPriKey, RSA_PKCS1_PADDING)) == -1) {
		ERR_load_crypto_strings();
		ERR_error_string(ERR_get_error(), err);
		fprintf(stderr, "Error encrypting message: %s\n", err);
		goto free_stuff;
	}
	memcpy(Assignment.sign, sign, sizeof(sign)); // store sign value
	fclose(sendPriFP);
	printf("4.Encrypt Information and Store to SIGN COMPLETE!\n");

	if((structFP = fopen("201103622_structure.dat", "wb")) == NULL) {
		printf("Cannot Open Struct File.\n");
		exit(1);
	}
	fwrite(&Assignment, sizeof(Assignment), 1, structFP);
	fclose(structFP);
	printf("Save Info file COMPLETE!\n");


/*
 TEST: Read Structure 
	if((structFP = fopen("201103622_structure.dat", "r")) == NULL) {
		printf("Cannot Open Struct File.\n");
		exit(1);
	}
	struct Format example;
	fread(&example, sizeof(Assignment), 1, structFP);
	printf("id: %d\nEmail: %s\nname: %s\npubKey: %s\nEMSG: %s\nEKEY: %s\nSIGN:%s\n", example.id, example.email, example.name, example.pubKeyOfSender, example.encrypted_MSG, example.encrypted_SharedKey, example.sign);
	fclose(structFP);
*/

/*------Assignment 3------*/
/* Compare Hash value */

	printf("------Assignment 3 Start------\n");
	if((sendPubFP = fopen("public_201103622.pem", "r")) == NULL) {
		printf("Cannot Open sender Public Key File.\n");
		exit(1);
	}
	sendPubKey = PEM_read_RSAPublicKey(sendPubFP, NULL, NULL, NULL);

	if((d_sign_len = RSA_public_decrypt(sign_len, Assignment.sign, d_sign, sendPubKey,RSA_PKCS1_PADDING)) == -1) {
		ERR_load_crypto_strings();
		ERR_error_string(ERR_get_error(), err);
		fprintf(stderr, "Error decrypting message: %s\n", err);
		goto free_stuff;
	}
	fclose(sendPubFP);

	result = memcmp(d_sign, sha256_str, d_sign_len);
	if(!result) printf("Authentication Success!\n");
	else printf("Authentication FAIL!\n");

/* Decrypt -> Encrypted Shared Key */
	printf("ENcrypt LENGTH: %d\n", encrypt_len);
	if((recvPriFP = fopen("priKey_12.pem", "r")) == NULL) {
		printf("Cannot Open receiver Private Key File.\n");
		exit(1);
	}
	recvPriKey = PEM_read_RSAPrivateKey(sendPubFP, NULL, NULL, NULL);
	decrypt = malloc(encrypt_len);
	if((decrypt_len = RSA_private_decrypt(encrypt_len, (unsigned char *)Assignment.encrypted_SharedKey, (unsigned char *)decrypt, recvPriKey, RSA_PKCS1_OAEP_PADDING)) == -1) {
		ERR_load_crypto_strings();
		ERR_error_string(ERR_get_error(), err);
		fprintf(stderr, "Error decrypting message: %s\n", err);
		goto free_stuff;
	}

	printf("DLEN = %d\n", decrypt_len);
	fclose(recvPriFP);
	printf("Decrypt COMPLETE!\n");
	printf("Decrypt Result(Shared Key): %s\n", decrypt);
	printf("Original Shared Key: %s\n", ckey);

/* Use Decrypted Shared key decrypt -> Encrypted Message */

	d_msg = malloc(sizeof(e_msg));
	aes_encrypt(Assignment.encrypted_MSG, d_msg, 8, decrypt);
	printf("Decrypt MSG: %s\n", d_msg);
	printf("Original MSG: %s\n", msg);
	printf("------END------\n");

	free_stuff:
	free(e_msg);
	free(d_msg);
	free(err);
	free(sendPubKey);
	free(sendPriKey);
	free(recvPubKey);
	free(recvPriKey);
	free(encrypt);
	free(decrypt);
	return 0;
}
