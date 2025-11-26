class ExcelSheetColumnNumber {
    public int titleToNumber(final String columnTitle) {
        if (columnTitle == null || columnTitle.isEmpty()) {
            return 0; // or throw an IllegalArgumentException
        }

        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result *= 26;
            result += (columnTitle.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
