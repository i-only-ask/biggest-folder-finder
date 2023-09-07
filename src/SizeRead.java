public class SizeRead {
    private static String[] sizeNames =
            {"b", "kb", "Mb", "Gb"};

    public static String getHumanReadableSize(long size) {
        int power = (int) (Math.log(size) / Math.log(1024));
        double value = size / Math.pow(1024, power);
        double roundedValue = Math.round(value * 100) / 100.;
        return roundedValue + " " + sizeNames[power];
    }
    public static long getSizeFromHumenReadabl(String size){
        String letters = size.replaceAll("[^a-zA-Z]", "");
        long digits = Long.valueOf(size.replaceAll("[^0-9]", ""));// в лонг нельзя первести цифйры с точкой, поэтому надо обязательно делить на 10
        long sizeComp = Math.round(digits) / 10 ;

        try {
            for (int i = 0; i < sizeNames.length; i++) {
                if (letters.equals(sizeNames[i])) {
                    sizeComp = (long) ((Math.pow(1024, i)) * sizeComp);
                }
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка преобразования строки в long: " + e.getMessage());
        }
        return sizeComp;
    }
}
