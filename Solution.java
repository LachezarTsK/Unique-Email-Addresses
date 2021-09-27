
import java.util.Set;
import java.util.HashSet;

public class Solution {

    public int numUniqueEmails(String[] emails) {

        Set<String> uniqueEmails = new HashSet<>();
        int n = emails.length;

        for (int i = 0; i < n; i++) {

            char[] array = emails[i].toCharArray();
            int indexATsign = indexATsign(array);
            int indexFirstPlus = indexFirstPlus(array, indexATsign);
            int indexFirstPart = indexFirstPlus > -1 ? indexFirstPlus : indexATsign;

            uniqueEmails.add(clearEmail(array, indexFirstPart, indexATsign));
        }
        return uniqueEmails.size();
    }

    public int indexATsign(char[] array) {
        int index = 0;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] == '@') {
                index = i;
                break;
            }
        }
        return index;
    }

    public int indexFirstPlus(char[] array, int indexATsign) {
        int n = indexATsign;
        for (int i = 0; i < n; i++) {
            if (array[i] == '+') {
                return i;
            }
        }
        return -1;
    }

    /*
    Both 'indexFirstPart',  'indexATsign' are arguments for the method, since 
    they might the different, depending on whether substring(0, indexOf('@')) 
    the contains the character '+'.
 
    To reconstruct the cleared eamil without encumbering 'if-else' statements,
    we need both indexes.
     */
    public String clearEmail(char[] array, int indexFirstPart, int indexATsign) {

        StringBuilder clearedEmail = new StringBuilder();
        for (int i = 0; i < indexFirstPart; i++) {
            if (array[i] != '.') {
                clearedEmail.append(array[i]);
            }
        }
        //This loops starts only if 'indexFirstPart != indexATsign'
        int n = array.length;
        for (int i = indexATsign; i < n; i++) {
            clearedEmail.append(array[i]);
        }
        return clearedEmail.toString();
    }
}
