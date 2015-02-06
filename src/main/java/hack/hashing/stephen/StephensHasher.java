package hack.hashing.stephen;


import hack.hashing.data.WebPage;
import hack.hashing.interfaces.Hash;
import hack.hashing.interfaces.Hasher;
import hack.hashing.stephen.StephensHash;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StephensHasher implements Hasher {

    private static String SINGLE_SPACE = " ";
    private static String WHITE_SPACE = "\\s+";
    private static final Function<String, List<String>> tokenizer =
            (input) -> (input == null)
                    ? Arrays.asList(SINGLE_SPACE)
                    : Arrays.asList(input.trim().replaceAll(WHITE_SPACE, SINGLE_SPACE).split(SINGLE_SPACE));

    private static final BiFunction<StephensHash,StephensHash, HashSet<String>> hashUnion =
            (a, b) -> {
                HashSet<String> union = new HashSet<>(a.shingleSet());
                union.addAll(b.shingleSet());
                return union;};

    private static final BiFunction<StephensHash, StephensHash, HashSet<String>> hashIntersection =
            (a, b) -> {
                HashSet<String> intersection = new HashSet<>(a.shingleSet());
                intersection.retainAll(b.shingleSet());
                return intersection;};

    @Override
    public Hash hash(WebPage webpage) {
        int shingleSize = 3;
        List<String> unigrams = tokenizer.apply(webpage.domString());
        ArrayDeque<String> shingle = new ArrayDeque<>(shingleSize);
        HashSet<String> shingleSet = new HashSet<>(unigrams.size() - (shingleSize - 1));
        unigrams.forEach(unigram -> { shingle.add(unigram);
            if (shingle.size() == shingleSize) {
                shingleSet.add(Arrays.asList(shingle.toArray(new String[shingleSize]))
                        .stream()
                        .collect(Collectors.joining(SINGLE_SPACE)));
                shingle.poll();}});
        return new StephensHash(shingleSet);
    }

    @Override
    public Double compare(Hash hash1, Hash hash2) {
        if (!(hash1 instanceof StephensHash) || !(hash2 instanceof StephensHash)){return 0d;}
        StephensHash a = ((StephensHash) hash1);
        StephensHash b = ((StephensHash) hash2);
        if (a.shingleSet().isEmpty() || b.shingleSet().isEmpty())
            return (a.shingleSet().isEmpty() && b.shingleSet().isEmpty()) ? 1.0d : 0.0d;
        HashSet<String> union = hashUnion.apply(a, b);
        HashSet<String> intersection = hashIntersection.apply(a, b);
        if (union.size() == 0 && intersection.size() == 0) return 1.0d;
        return (double)intersection.size() / (double)union.size();
    }

    @Override
    public boolean unique(Hash hash) {
        return false;
    }
}
