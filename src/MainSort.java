import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainSort {
    private static boolean isSortTypeDescending;
    private static final String DESCENDING_SORT = "-d";
    private static boolean isDataTypeString;
    private static final String DATA_TYPE_STRING = "-s";
    private static final String REGX_FILE = "\\w+.txt";
    private static String outFileName;

    public static void main(String[] args) {
        try {
            startProgram(args);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("set all the necessary data and restart the program");
        }
    }

    private static void startProgram(String[] args) {
        Pattern pattern = Pattern.compile(REGX_FILE);
        Matcher matcher;
        ArrayList<String> fileNames = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(DESCENDING_SORT)) {
                isSortTypeDescending = true;
            }
            if (args[i].equals(DATA_TYPE_STRING)) {
                isDataTypeString = true;
            }
            if (pattern.matcher(args[i]).matches()) {
                fileNames.add(args[i]);
            }
        }

        outFileName = fileNames.get(0);

        String[] dataFiles = readFiles(fileNames);

        MergeSort mergeSort = new MergeSort();
        if (isDataTypeString) {
            writeFile(mergeSort.merge(dataFiles), outFileName, isSortTypeDescending);
        } else {
            int[] data = new int[dataFiles.length];
            for (int i = 0; i < dataFiles.length; i++) {
                try {
                    data[i] = Integer.parseInt(dataFiles[i]);
                } catch (NumberFormatException e) {
                    System.out.println("invalid data type");
                }
            }
            writeFile(mergeSort.merge(data), outFileName, isSortTypeDescending);
        }
    }

    public static String[] readFiles(ArrayList<String> fileNames) {
        ArrayList<String> finalList = new ArrayList<>();

        for (int i = 1; i < fileNames.size(); i++) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNames.get(i)))) {
                while (bufferedReader.ready()) {
                    finalList.add(bufferedReader.readLine());
                }
            } catch (IOException e) {
                System.out.println("File read error. Perhaps such a file does not exist");
            }
        }
        String[] arrData = new String[finalList.size()];
        for (int i = 0; i < finalList.size(); i++) {
            arrData[i] = finalList.get(i);
        }
        return arrData;
    }

    public static void writeFile(String[] sortFiles, String outFileName, boolean descendingSort) {
        try (FileWriter fileWriter = new FileWriter(outFileName, true)) {
            if (descendingSort) {
                for (int i = sortFiles.length - 1; i >= 0; i--)
                    fileWriter.write(sortFiles[i] + "\n");
            } else {
                for (int i = 0; i < sortFiles.length; i++)
                    fileWriter.write(sortFiles[i] + "\n");
            }
        } catch (IOException e) {
            System.out.println("Write error");
        }
    }

    public static void writeFile(int[] sortFiles, String outFileName, boolean descendingSort) {
        try (FileWriter fileWriter = new FileWriter(outFileName, true)) {
            if (descendingSort) {
                for (int i = sortFiles.length - 1; i >= 0; i--)
                    fileWriter.write(sortFiles[i] + "\n");
            } else {
                for (int i = 0; i < sortFiles.length; i++)
                    fileWriter.write(sortFiles[i] + "\n");
            }
        } catch (IOException e) {
            System.out.println("Write error");
        }
    }
}
