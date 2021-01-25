class Main {
  public static void main(String[] args) {
    String s = "aabcccccaaa";
    
    System.out.println(s);
    System.out.println(compression(s));
  }

  public static String compression(String s) {
    int repeat = 0;
    int finalLength = compressedLength(s);
    StringBuilder sb = new StringBuilder(finalLength);

    if (finalLength >= s.length()) {
      return s;
    }

    for (int i = 0; i < s.length(); ++i) {
      repeat++;

      if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
        sb.append(s.charAt(i));
        sb.append(repeat);
        repeat = 0;
      }
    }

    return sb.toString();
}

  public static int compressedLength(String s) {
    int repeat = 0;
    int length = 0;

    for (int i = 0; i < s.length(); ++i) {
      repeat++;
      if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
        length += 1 + String.valueOf(repeat).length();
        repeat = 0;
      }
    }

    return length;
  }
}