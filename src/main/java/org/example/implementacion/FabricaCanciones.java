package org.example.implementacion;


import java.util.HashMap;
import java.util.Map;

public class FabricaCanciones {

    public static boolean HabilitarFlyweight = true;
    private static final Map<String, Cancion> PLAY_CANCION = new HashMap<>();
    private static final Map<String, Artista> ARTISTAS = new HashMap<>(); // Mapa para almacenar artistas
    private static Long Secuencia = 0L;

    public static Cancion CrearItem(String NombreTema, String NombreArtista) {
        if (HabilitarFlyweight && PLAY_CANCION.containsKey(NombreTema)) {
            return PLAY_CANCION.get(NombreTema);
        } else {
            Artista artista = ARTISTAS.computeIfAbsent(NombreArtista, nombre -> new Artista(++Secuencia, nombre));
            Cancion playItem = new Cancion(++Secuencia, NombreTema, artista); // Asociamos el artista
            PLAY_CANCION.put(NombreTema, playItem);
            return playItem;
        }
    }
}
