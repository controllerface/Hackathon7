package hack.hashing.sarah;

import hack.hashing.data.WebPage;
import hack.hashing.interfaces.Hash;
import hack.hashing.interfaces.Hasher;

/**
 * Created by Fancy on 2/5/15.
 */
public class SarahsHasher implements Hasher {
    @Override
    public Hash hash(WebPage webpage) {
        //three components to a hash.



        return null;
    }

    @Override
    public Double compare(Hash hash1, Hash hash2) {
        return null;
    }

    @Override
    public boolean unique(Hash hash) {
        return false;
    }
}
