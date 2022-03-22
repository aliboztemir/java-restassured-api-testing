package java_resources;

// Enum is a special class in Java which is a collection of constants and methods
public enum APIResources {
    ListUsersAPI("/api/users?page=1"),
    SingleUserAPI("/api/users/{id}"),
    CreateUserAPI("/api/users"),
    PutUserAPI("/api/users/{id}"),
    PatchUserAPI("/api/users/{id}"),
    DeleteUserAPI("/api/users/{id}");

    private String resource;

    APIResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
