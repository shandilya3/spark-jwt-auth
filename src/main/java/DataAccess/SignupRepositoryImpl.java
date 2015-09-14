package DataAccess;

import Model.UserSignupModel;
import RedisContext.IRedis;
import Util.JsonTransformer;
import com.google.inject.Inject;

/**
 * Created by previousdeveloper on 14.09.2015.
 */
public class SignupRepositoryImpl implements ISignupRepository {

    private IRedis redis;

    @Inject
    public SignupRepositoryImpl(IRedis redis) {

        this.redis = redis;
    }

    public void saveUser(UserSignupModel userSignupModel) {

        String value = null;

        try {
            value = new JsonTransformer().render(userSignupModel);
            redis.jedis().set("signUp", value);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}