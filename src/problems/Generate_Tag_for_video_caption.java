package problems;

public class Generate_Tag_for_video_caption {
    public static void main(String[] args) {
        String s = "FkVsgzfhQxPYKr WtaCvDuHQeo roeVHIoPorZuIuMDxhYVs jlfCrXCDqBVjgmzxxmZOpUpCc  eHMpZrNxilBPngylMcS";
        System.out.println(generateTag(s));
    }

    public static String generateTag(String caption) {
        String[] arr = caption.trim().split("\\s+");
        StringBuilder st = new StringBuilder("#");

        for(int i = 0; i < arr.length; i++){
            if(st.length() > 100){
                break;
            }
            if(i != 0){
                st.append(Character.toUpperCase(arr[i].charAt(0)));
                st.append(arr[i].substring(1).toLowerCase());
                continue;
            }
            st.append(arr[i].toLowerCase());
        }

        return st.length() > 100 ? st.substring(0, 100) : st.toString();
    }
}
