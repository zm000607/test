package service;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface ItemService {

    @GET("news/latest")
    Observable<ResponseBody>getDailyList();


    @GET("/wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<ResponseBody>getWeChatList();

    @GET("news/hot")
    Observable<ResponseBody>getTagsList();

    @GET("sections")
    Observable<ResponseBody>getSCList();
}
