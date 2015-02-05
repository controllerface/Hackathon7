package main.stephen;

import main.WebPage;
import main.interfaces.Hash;
import main.interfaces.Hasher;

/**
 * Created by Controllerface on 2/5/2015.
 */
public class StephensHasher implements Hasher {
    @Override
    public Hash hash(WebPage webpage) {
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
