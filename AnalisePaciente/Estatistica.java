public class Estatistica{
        public double media(int v[]){
               int soma = 0;
               for(int i=0;i<=v.length-1;i++){
                       soma += v[i];
               }
               return (double)soma/(v.length);
        }
        
        public double variancia(int v[]){
               double m = media(v);
               double s = 0;
               for(int i=0;i<=v.length-1;i++)
                       s += Math.pow((m-v[i]),2); 
              
               return (double)s/(v.length-1);    
        }
        
        public double desvPad(int v[]){
               return Math.sqrt(variancia(v));
        }
        
        
}