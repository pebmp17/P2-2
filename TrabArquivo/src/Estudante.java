public class Estudante {
    
        private String nome;
        private String resposta;          
        private int acertos; 

        public Estudante (String nome , int acertos){
            this.nome=nome;
            this.acertos=acertos;
        }



        public String getNome() {
               return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getResposta() {
            return resposta;
        }

        public void setResposta(String resposta) {
            this.resposta = resposta;
        }

        public int getAcertos() {
            return acertos;
        }

        public void setAcertos(int acertos) {
            this.acertos = acertos;
        }

    

            
    
}

    

