public class Main {
    public static void main(String[] args) {
        boolean [] lettere = new boolean [26];

        //string output
        String frase = "Carla, mia sorella, abita a New York, negli Stati Uniti";

        //capital letters in the string
        System.out.println("LE LETTERE MAIUSCOLE NELLA STRINGA SONO: ");
        //for loop
        for(int i=0; i<frase.length(); i++){
            char ch=frase.charAt(i);
            //if the letter is capital
            if (Character.isUpperCase(ch)) { //METODO PER DETERMINARE UN CARATTERE MAIUSCOLO-->METHOD FOR DETERMINING AN UPPERCASE CHARACTER
                System.out.print(ch + " ");
            }
        }

    }
}