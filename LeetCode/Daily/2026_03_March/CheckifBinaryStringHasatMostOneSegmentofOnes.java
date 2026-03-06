class CheckifBinaryStringHasatMostOneSegmentofOnes {
    public boolean checkOnesSegment(String s) {
        // If "01" exists, it means there's more than one segment of '1's
        return s.indexOf("01") == -1;
    }
}