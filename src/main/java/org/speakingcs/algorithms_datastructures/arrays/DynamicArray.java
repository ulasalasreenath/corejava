package org.speakingcs.algorithms_datastructures.arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DynamicArray {


    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> seqList = new ArrayList<>(n);

        for(int i = 0; i < n; i++) {
            seqList.add(new ArrayList<Integer>());
        }
        List<Integer> lastAnswers = new ArrayList<>();
        int lastAnswer = 0;
        for (List<Integer> query : queries) {
            if (query.get(0) == 1) {
                seqList.get((query.get(1) ^ lastAnswer) % n).add(query.get(2));
            }
            if (query.get(0) == 2) {
                List<Integer> seq = seqList.get((query.get(1) & lastAnswer) % n);
                lastAnswer =  seq.get(query.get(2) % seq.size());
                lastAnswers.add(lastAnswer);
                System.out.println(lastAnswer);
            }
        }

        return lastAnswers;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                           );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
                            );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

