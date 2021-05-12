package Chpt2.item5;

public class SpellChecker {
        private final Lexicon dictionary; // class Lexicon : dictionary material 
        
        public SpellChecker(Lexicon dictionary){ // 의존 객체 주입
            this.dictionary = dictionary;
        }
        public boolean isValid(String word){...}
        public List<String> suggestions(String type){...}
}
