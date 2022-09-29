//package buddle.buddlebuddy.config.auth;
//
//import buddle.buddlebuddy.user.Role;
//import buddle.buddlebuddy.user.User;
//import lombok.Getter;
//
//import java.util.Map;
//
//@Getter
//public class OAuthAttributes {
//    private Map<String, Object> attributes;
//    private String nameAttributeKey;
//    private String name;
//    private String email;
//
//    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email) {
//        this.attributes = attributes;
//        this.nameAttributeKey = nameAttributeKey;
//        this.name = name;
//        this.email = email;
//    }
//
//    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
//        if ("naver".equals(registrationId)) {
//            return ofNaver("id", attributes);
//        }
//        return ofGoogle(userNameAttributeName, attributes);
//    }
//
//    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
//        return new OAuthAttributes(attributes, userNameAttributeName, (String) attributes.get("name"), (String) attributes.get("email"));
//    }
//
//    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
//        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
//
//        return new OAuthAttributes(response, userNameAttributeName, (String) attributes.get("name"), (String) attributes.get("email"));
//    }
//
//    public User toEntity() {
//        return new User(name, email, Role.USER);
//    }
//}
