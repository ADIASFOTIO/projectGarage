package com.adias.demo.config;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.github.scribejava.apis.FlickrApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
// permette a spring di capire che è una classe di configurazione all'inizio del program
//dopo aver fatto la config possiamo cancelare
@Configuration
public class FlickrConfiguration {
   private String apiKey ="8f063e3839fb892506445cb7d32cfffc";
    private String apiSecret ="692a15bc23cb525f";
    private String appkey = "72157720881868103-e14bcac696d27a40";
    private String appSecret = "23c507db7a7aead9";
    // metodo con bean permette a spring di eseguire il metodo all'inizio del programma
    // metodo che permette di generare l apikey and apiSecret
    /**@Bean
    public Flickr getFlickr () throws IOException, ExecutionException, InterruptedException, FlickrException {
        //creo un ogetto del tipo flickr
        Flickr flickr = new Flickr(apiKey, apiSecret, new REST());
        //creo un ogetto OAuth10aService con il permesso che voglio con la mia app
        OAuth10aService service = new ServiceBuilder(apiKey)
                .apiSecret(apiSecret)
                // .DELETE mi da tutti i diritti sulle foto
                .build(FlickrApi.instance(FlickrApi.FlickrPerm.DELETE));
        final Scanner scanner = new Scanner(System.in);
        final OAuth1RequestToken request = service.getRequestToken();
        final String authUrl = service.getAuthorizationUrl(request);
        System.out.println(authUrl);
        System.out.println("Paste it here >>");
        final String authVerifier = scanner.nextLine();
        OAuth1AccessToken accessToken = service.getAccessToken(request,authVerifier);
        System.out.println(accessToken.getToken());
        System.out.println(accessToken.getTokenSecret());
        //verificoche il token recuperato è valido
        Auth auth = flickr.getAuthInterface().checkToken(accessToken);
        System.out.println("//////////////////////////////////");
        System.out.println(accessToken.getToken());
        System.out.println(accessToken.getTokenSecret());
        return flickr;
    }*/
    @Bean
    public Flickr getFlickr (){
        Flickr flickr = new Flickr(apiKey, apiSecret, new REST());
        Auth auth = new Auth();
        auth.setPermission(Permission.DELETE);
        auth.setToken(appkey);
        auth.setToken(appSecret);
        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(auth);
        flickr.setAuth(auth);
        return flickr;
    }


}

