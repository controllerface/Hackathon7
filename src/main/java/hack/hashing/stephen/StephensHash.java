package hack.hashing.stephen;

import hack.hashing.interfaces.Hash;

import java.util.Set;

/**
 * Created by Controllerface on 2/5/2015.
 */
public class StephensHash implements Hash {
    final Set<String> shingleSet;

    public StephensHash(Set<String> shingleSet) {
        this.shingleSet = shingleSet;
    }

    public Set<String> shingleSet(){
        return shingleSet;
    }
}
