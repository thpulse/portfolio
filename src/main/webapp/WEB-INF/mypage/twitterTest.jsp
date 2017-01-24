<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script type="text/javascript">
/**
 *  JQUERY4U
 *
 *  Displays the latest tweets.
 *
 *  @author      Sam Deering
 *  @copyright   Copyright (c) 2012 JQUERY4U Pty Ltd
 *  @license     http://jquery4u.com/license/
 *  @since       Version 1.0
 *  @filesource  js/jquery4u.twitter.js
 *
 */

(function($,W,D)
{
    W.JQUERY4U.TWITTER = {

        name: "JQUERY4U TWITTER",

        init: function(wid)
        {
            //helper functions
            String.prototype.linkify=function(){
              return this.replace(/[A-Za-z]+://[A-Za-z0-9-_]+.[A-Za-z0-9-_:%&;?/.=]+/g,function(m){
                return m.link(m);
              });
            };
            String.prototype.linkuser=function(){
              return this.replace(/[@]+[A-Za-z0-9-_]+/g,function(u){
                return u.link("http://twitter.com/"+u.replace("@",""));
              });
            };
            String.prototype.linktag=function(){
              return this.replace(/[]+[A-Za-z0-9-_]+/,function(t){
                return t;
              });
            };

            //load twitter stylesheet
            $("head").append('');

            //get the tweets from Twitter API
            $.getJSON("http://search.twitter.com/search.json?q=jquery4u&rpp=5&callback=?", function(data)
            {
                // console.log(data.items.length);
                $(data.results).each(function(i,v)
                {

                      var tTime=new Date(Date.parse(this.created_at));
                      var cTime=new Date();
                      var sinceMin=Math.round((cTime-tTime)/60000);
                      if(sinceMin==0){
                        var sinceSec=Math.round((cTime-tTime)/1000);
                        if(sinceSec<10)
                          var since='less than 10 seconds ago';
                        else if(sinceSec<20)
                          var since='less than 20 seconds ago';
                        else
                          var since='half a minute ago';
                      }
                      else if(sinceMin==1){
                        var sinceSec=Math.round((cTime-tTime)/1000);
                        if(sinceSec==30)
                          var since='half a minute ago';
                        else if(sinceSec<60)
                          var since='less than a minute ago';
                        else
                          var since='1 minute ago';
                      }
                      else if(sinceMin<45)
                        var since=sinceMin+' minutes ago';
                      else if(sinceMin>44&&sinceMin<60)
                        var since='about 1 hour ago';
                      else if(sinceMin<1440){
                        var sinceHr=Math.round(sinceMin/60);
                        if(sinceHr==1)
                          var since='about 1 hour ago';
                        else
                          var since='about '+sinceHr+' hours ago';
                      }
                      else if(sinceMin>1439&&sinceMin<2880)
                        var since='1 day ago';
                      else{
                        var sinceDay=Math.round(sinceMin/1440);
                        var since=sinceDay+' days ago';
                      }
                      var tweetBy='@'+this.from_user+' '+since+'';
                      tweetBy=tweetBy+' &middot; Reply';
                      tweetBy=tweetBy+' &middot; View Tweet';
                      tweetBy=tweetBy+' &middot; RT';
                      var tweet=''+this.text.linkify().linkuser().linktag().replace(/'+tweetBy+'';

                      $("#twitter").append(tweet); //add the tweet...

                });
            });
        }
    }

})(jQuery,window,document);
</script>
</head>
<body>

</body>
</html>