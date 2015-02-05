/**
 * Created by Fancy on 2/5/15.
 */
public interface Hasher {
    Hash hash(Webpage webpage);

    /**
     *
      * @param hash1
     * @param hash2
     * @return returns the percent similarity of the two hashes.
     */
    Double compare(Hash hash1, Hash hash2);

    /**
     *
     * @param hash
     * @return compares against list of hashes and returns true if unique
     */
    boolean unique(Hash hash);


}
