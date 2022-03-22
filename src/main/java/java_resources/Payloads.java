package java_resources;


import pojo.*;

public class Payloads {


    public static CreateUser createUserApiPayload(String name, String job) {
        CreateUser createUser = new CreateUser();

        createUser.setName(name);
        createUser.setJob(job);

        return createUser;
    }

    public static PutUser putUserApiPayload(String name, String job) {
        PutUser putUser = new PutUser();

        putUser.setName(name);
        putUser.setJob(job);

        return putUser;
    }

    public static PatchUser patchUserApiPayload(String name, String job) {
        PatchUser patchUser = new PatchUser();

        patchUser.setName(name);
        patchUser.setJob(job);

        return patchUser;
    }
}
