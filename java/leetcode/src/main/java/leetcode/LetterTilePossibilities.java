package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {

        return this.onlyGivenString(tiles);
    }

    public int onlyGivenString(String tiles) {

        List<Character> inputList = new ArrayList<Character>();

        for (Character c : tiles.toCharArray()) {
            inputList.add(c);
        }

        // System.out.println(MessageFormat.format("Input Char set = {0}", inputList));

        List<String> result = new ArrayList<String>();

        setPossibilities(result, null, inputList, inputList.size());

        // System.out.println(MessageFormat.format("Resulted set = {0}", result));
        return result.size();

    }

    private void setPossibilities(List<String> resultList, String currentString, List<Character> charList, int depth) {
        List<Character> workedList = new ArrayList<Character>();

        for (Character nodeChar : charList) {

            if (workedList.contains(nodeChar)) {
                continue;
            }

            workedList.add(nodeChar);

            List<Character> nodeList = new ArrayList<Character>(charList);
            nodeList.remove(nodeChar);
            if (null == currentString) {
                resultList.add(String.valueOf(nodeChar));
                setPossibilities(resultList, String.valueOf(nodeChar), nodeList, depth - 1);
            } else {
                String newNodeString = currentString.concat(String.valueOf(nodeChar));
                resultList.add(newNodeString);
                setPossibilities(resultList, newNodeString, nodeList, depth - 1);
            }
        }

    }

}
