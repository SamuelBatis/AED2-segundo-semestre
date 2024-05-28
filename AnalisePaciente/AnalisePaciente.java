/* ****************************************************************************************
 * Faculdade de Engenharias Arquitetura e Urbanismo (FEAU) - (Univap)
 * Curso: Engenharia da Computacao - Data de Entrega: 17/04/2024
 * Autor: Prof. Wagner dos Santos Clementino de Jesus
 *
 * Turma: 8UNA Disciplina: Algoritmos Estrutura de Dados - II
 * Resolucao da Avaliacao - I
 * Observacao:
 *
 * AnalisePaciente.java
 * ***************************************************************************************/
import java.util.Scanner;
public class AnalisePaciente {    
        public static void print(String str){
               System.out.println(str);
        }
        
        public static void mostra_dados(FilaPilha fila){
               while(!fila.vazia()) {
                     Paciente paciente = new Paciente();
                     paciente = (Paciente)fila.desenfileirar();
                     print(paciente.getID()+","+paciente.getpress_manha()+ ","+
                           paciente.getpress_tarde()+","+paciente.getpress_noite());
               }
        }
        
        public static void resultadoSaida(FilaPilha fila){
               int paciente = 1;
               while(!fila.vazia()) {
                     int valor[] = new int[21];
                     for(int i=0;i<=20;i++) {
                            valor[i] = (int)fila.desenfileirar(); 
                     }
                     Estatistica esta = new Estatistica();
                     print("Paciente: "+paciente);
                     print("Media: "+String.format("%2.2f",esta.media(valor)));
                     print("Desvio Padrao: "+String.format("%2.2f",esta.desvPad(valor)));
                     print("variancia: "+String.format("%2.2f",esta.variancia(valor)));
                     print("\n");
                     paciente++;
                }
        }
        
        public static void calcular(FilaPilha fila, int np){
                int v[] = new int[21*np];
                Paciente paciente = new Paciente();
                int indice = 0;
                for(int i=1;i<=np;i++){
                  for(int j=1;j<=7;j++) {
                           if(!fila.vazia()) {
                              paciente = (Paciente)fila.desenfileirar();
                              int manha = paciente.getpress_manha();
                              int tarde = paciente.getpress_tarde();
                              int noite = paciente.getpress_noite();
                              v[indice] = manha; 
                              v[indice+1] = tarde;
                              v[indice+2] = noite;
                              indice+=3;
                           }
                  }
                }
                
                FilaPilha filanova = new FilaPilha();
                for(int i=0;i<=(21*np)-1;i++) {
                        filanova.enfileirar(v[i]);
                        //print(""+v[i]);
                } 
                
                resultadoSaida(filanova);
                
                //mostra_dados(fila); 
        }
        
        public static void main(String args[]){
               Scanner entrada = new Scanner(System.in);
               FilaPilha filapilha = new FilaPilha();
               int n = Integer.parseInt(entrada.nextLine());
               // For total
               
               for(int i=1;i<=n;i++){
                  for(int j=1;j<=7;j++) {
                     Paciente paciente = new Paciente();
                     paciente.setID((byte)i);
                     int manha = Integer.parseInt(entrada.next());
                     int tarde = Integer.parseInt(entrada.next());
                     int noite = Integer.parseInt(entrada.next());
                     paciente.setpress_manha(manha);
                     paciente.setpress_tarde(tarde);
                     paciente.setpress_noite(noite);
                     
                     filapilha.enfileirar(paciente);
                  }
               }
               
               
               //mostra_dados(filapilha);
              // for(int i=1;i<=n;i++)
              calcular(filapilha, n);
               
        }
}

