package ec.com.uce;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ec.com.uce.application.service.EquipoService;
import ec.com.uce.domain.model.Equipo;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);    
    }
    public static class App implements QuarkusApplication{
        @Inject
        private EquipoService equipoService;




        @Override
        public int run(String... args) throws Exception {
            System.out.println("Iniciando las auditorias");
            List<Equipo> lista = new ArrayList<>();
            Random random = new Random();
            
            for(int i=1; i <= 500; i++){
                Equipo e1 = new Equipo();
                e1.setNombre("Equipo " + i);
                e1.setPais("Ecuador");
                e1.setConfederacion("CONMEBOL");
                e1.setTitulos(random.nextInt(0, 10));
                lista.add(e1);
            }

            this.equipoService.guardarLista(lista);
            
            return 0;
        }
        
    }
    
}