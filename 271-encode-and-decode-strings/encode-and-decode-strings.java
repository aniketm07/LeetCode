
public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        for(int i=0; i<strs.size(); i++){
            if(strs.get(i).isEmpty()){
                strs.set(i, "%20");
            }
        }
        String str = String.join(";<>;", strs);
        return str;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] decodedArray = s.split(";<>;");
        for(int i=0;i<decodedArray.length;i++){
            if(decodedArray[i].equals("%20")){
                decodedArray[i]= "";
            }
        }
        return Arrays.asList(decodedArray);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));