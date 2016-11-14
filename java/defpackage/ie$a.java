package defpackage;

import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.models.GroupNameCheck;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.models.NetworkData.UploadResponse;
import com.becandid.candid.models.PostInfoResponse;
import java.util.Map;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: ApiService */
interface ie$a {
    @POST("api/unblock_thread")
    @FormUrlEncoded
    apd<NetworkData> A(@FieldMap Map<String, String> map);

    @POST("api/delete_thread")
    @FormUrlEncoded
    apd<NetworkData> B(@FieldMap Map<String, String> map);

    @POST("api/get_my_info")
    apd<NetworkData> a();

    @POST("api/logout")
    @FormUrlEncoded
    apd<NetworkData> a(@Field("forever") int i);

    @POST("api/like_comment")
    @FormUrlEncoded
    apd<EmptyClass> a(@Field("comment_id") int i, @Field("value") int i2);

    @POST("api/report_group")
    @FormUrlEncoded
    apd<NetworkData> a(@Field("group_id") int i, @Field("reason") String str);

    @POST("api/update_group")
    @FormUrlEncoded
    apd<NetworkData> a(@Field("group_id") int i, @Field("group_name") String str, @Field("about") String str2, @Field("tags") String str3, @Field("source_url") String str4);

    @POST("api/get_post_info")
    @FormUrlEncoded
    apd<PostInfoResponse> a(@Field("url") String str);

    @POST("api/check_group_name")
    @FormUrlEncoded
    apd<GroupNameCheck> a(@Field("group_name") String str, @Field("will_use_duplicate") int i);

    @POST("api/report_post")
    @FormUrlEncoded
    apd<EmptyClass> a(@Field("post_id") String str, @Field("reason") String str2);

    @POST("api/update_device_token")
    @FormUrlEncoded
    apd<EmptyClass> a(@Field("device_token") String str, @Field("platform_type") String str2, @Field("version_type") String str3);

    @POST("api/create_group")
    @FormUrlEncoded
    apd<NetworkData> a(@Field("group_name") String str, @Field("about") String str2, @Field("tags") String str3, @Field("source_url") String str4);

    @POST("api/feed")
    @FormUrlEncoded
    apd<NetworkData> a(@Field("feed_type") String str, @Field("min_post_id") String str2, @FieldMap Map<String, String> map);

    @POST("api/add_post")
    @FormUrlEncoded
    apd<NetworkData> a(@FieldMap Map<String, String> map);

    @POST("api/splash_page")
    apd<aif> b();

    @POST("api/mark_read_activity")
    @FormUrlEncoded
    apd<EmptyClass> b(@Field("activity_id") int i);

    @POST("api/mute_post")
    @FormUrlEncoded
    apd<EmptyClass> b(@Field("post_id") String str);

    @POST("api/get_activity")
    @FormUrlEncoded
    apd<NetworkData> b(@Field("mark_read") String str, @Field("last_activity_id") String str2);

    @POST("api/like_post")
    @FormUrlEncoded
    apd<NetworkData> b(@Field("post_id") String str, @Field("value") String str2, @Field("is_rumor") String str3);

    @POST("api/post_comments")
    @FormUrlEncoded
    apd<NetworkData> b(@FieldMap Map<String, String> map);

    @POST("api/get_threads_requests_count")
    apd<NetworkData> c();

    @POST("api/join_group")
    @FormUrlEncoded
    apd<NetworkData> c(@Field("group_id") int i);

    @POST("api/unmute_post")
    @FormUrlEncoded
    apd<EmptyClass> c(@Field("post_id") String str);

    @POST("api/delete_post")
    @FormUrlEncoded
    apd<EmptyClass> c(@Field("post_id") String str, @Field("reason") String str2);

    @POST("api/invite_contacts")
    @FormUrlEncoded
    apd<EmptyClass> c(@Field("contacts_json") String str, @Field("upsell_id") String str2, @Field("name") String str3);

    @POST("api/new_user_hash")
    @FormUrlEncoded
    apd<aif> c(@FieldMap Map<String, String> map);

    @POST("api/mark_messages_visit")
    apd<NetworkData> d();

    @POST("api/skip_group")
    @FormUrlEncoded
    apd<NetworkData> d(@Field("group_id") int i);

    @POST("api/skip_upsell")
    @FormUrlEncoded
    apd<EmptyClass> d(@Field("upsell_id") String str);

    @POST("api/group_feed")
    @FormUrlEncoded
    apd<NetworkData> d(@Field("group_id") String str, @Field("min_post_id") String str2);

    @POST("api/sync_friends")
    @FormUrlEncoded
    apd<aif> d(@FieldMap Map<String, String> map);

    @POST("api/leave_group")
    @FormUrlEncoded
    apd<NetworkData> e(@Field("group_id") int i);

    @POST("api/generate_otp")
    @FormUrlEncoded
    apd<NetworkData> e(@Field("phone_number") String str);

    @POST("api/verify_phone_number")
    @FormUrlEncoded
    apd<NetworkData> e(@Field("otp_code") String str, @Field("phone_number") String str2);

    @POST("api/suggested_groups")
    @FormUrlEncoded
    apd<NetworkData> e(@FieldMap Map<String, String> map);

    @POST("api/profile")
    @FormUrlEncoded
    apd<NetworkData> f(@Field("user_id") int i);

    @POST("api/search_images")
    @FormUrlEncoded
    apd<aif> f(@Field("query") String str);

    @POST("api/start_upload")
    @FormUrlEncoded
    apd<UploadResponse> f(@Field("content_type") String str, @Field("form_id") String str2);

    @POST("api/auto_join_fb_groups")
    @FormUrlEncoded
    apd<NetworkData> f(@FieldMap Map<String, String> map);

    @POST("api/invite_group_friends")
    @FormUrlEncoded
    apd<EmptyClass> g(@Field("group_id") int i);

    @POST("api/click_notification")
    @FormUrlEncoded
    apd<EmptyClass> g(@Field("notification_id") String str);

    @POST("api/update_activity_settings")
    @FormUrlEncoded
    apd<NetworkData> g(@FieldMap Map<String, String> map);

    @POST("api/delete_group")
    @FormUrlEncoded
    apd<NetworkData> h(@Field("group_id") int i);

    @POST("api/server_message_seen")
    @FormUrlEncoded
    apd<EmptyClass> h(@Field("message_type") String str);

    @POST("api/delete_comment")
    @FormUrlEncoded
    apd<NetworkData> h(@FieldMap Map<String, String> map);

    @POST("api/all_interacted_posts")
    @FormUrlEncoded
    apd<NetworkData> i(@Field("page") int i);

    @POST("api/search_user_threads")
    @FormUrlEncoded
    apd<NetworkData> i(@Field("search_string") String str);

    @POST("api/report_comment")
    @FormUrlEncoded
    apd<NetworkData> i(@FieldMap Map<String, String> map);

    @POST("api/my_posts_on_scroll")
    @FormUrlEncoded
    apd<NetworkData> j(@Field("page") int i);

    @POST("api/add_comment")
    @FormUrlEncoded
    apd<NetworkData> j(@FieldMap Map<String, String> map);

    @POST("api/my_groups_on_scroll")
    @FormUrlEncoded
    apd<NetworkData> k(@Field("page") int i);

    @POST("api/update_user_tags")
    @FormUrlEncoded
    apd<NetworkData> k(@FieldMap Map<String, String> map);

    @POST("api/search_groups")
    @FormUrlEncoded
    apd<aif> l(@FieldMap Map<String, String> map);

    @POST("api/edit_post")
    @FormUrlEncoded
    apd<NetworkData> m(@FieldMap Map<String, String> map);

    @POST("api/edit_comment")
    @FormUrlEncoded
    apd<NetworkData> n(@FieldMap Map<String, String> map);

    @POST("api/update_user_info")
    @FormUrlEncoded
    apd<EmptyClass> o(@FieldMap Map<String, String> map);

    @POST("api/handle_message_request")
    @FormUrlEncoded
    apd<NetworkData> p(@FieldMap Map<String, String> map);

    @POST("api/add_message")
    @FormUrlEncoded
    apd<NetworkData> q(@FieldMap Map<String, String> map);

    @POST("api/get_threads_and_requests")
    @FormUrlEncoded
    apd<NetworkData> r(@FieldMap Map<String, String> map);

    @POST("api/get_thread")
    @FormUrlEncoded
    apd<NetworkData> s(@FieldMap Map<String, String> map);

    @POST("api/read_thread")
    @FormUrlEncoded
    apd<NetworkData> t(@FieldMap Map<String, String> map);

    @POST("api/login_fb_user")
    @FormUrlEncoded
    apd<NetworkData> u(@FieldMap Map<String, String> map);

    @POST("api/signupprocess")
    @FormUrlEncoded
    apd<NetworkData> v(@FieldMap Map<String, String> map);

    @POST("api/get_location_tags_groups")
    @FormUrlEncoded
    apd<NetworkData> w(@FieldMap Map<String, String> map);

    @POST("api/report_message")
    @FormUrlEncoded
    apd<NetworkData> x(@FieldMap Map<String, String> map);

    @POST("api/set_message_settings")
    @FormUrlEncoded
    apd<NetworkData> y(@FieldMap Map<String, String> map);

    @POST("api/block_thread")
    @FormUrlEncoded
    apd<NetworkData> z(@FieldMap Map<String, String> map);
}
