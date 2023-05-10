package com.adias.demo.services.implementations;
import com.adias.demo.services.abstractions.PhotoService;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.uploader.UploadMetaData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.InputStream;
@Service
@Slf4j
public class PhotoServiceImp implements PhotoService {
    private Flickr flickr;
    @Autowired
    private PhotoServiceImp(Flickr flickr){
        this.flickr = flickr;
    }
    @Override
    public String savePhoto(InputStream photo, String title) throws FlickrException {
        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setTitle(title);
        String photoId = flickr.getUploader().upload(photo, uploadMetaData);
        return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
    }
        // ci permette di connettersi a flickr
        /*private void connect(){
        flickr = new Flickr(apiKey, apiSecret, new REST());
        Auth auth = new Auth();
        auth.setPermission(Permission.DELETE);
        auth.setToken(appkey);
        auth.setToken(appSecret);
        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(auth);
        flickr.setAuth(auth);
    }*/
}
