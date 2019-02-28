package com.poireau.hashcode;

public class Algo {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        // On a une liste de slides (verticales et horizontales melangées)

        //On suppose qu'on a une variable slides contenant la listes des slides
        slides []Slide;
        presentation Presentation;
        slidesPairs []SlidePair;

        // Construction des paires de slides
        for (int i = 0; i < nbSlides; i++) {
            for (int j = 0; j < nbSlides; j++) {
                // Pas 2 fois la meme slides dans une paire
                if (i == j) {
                    continue;
                }

                pair = [slides[i], slides[j]];
                pair.computeScore();
                slidesPair.push(pair);
            }
        }

        // Trier la liste slidesPair selon le score DESC
        // TODO

        // Faire les associations
        // On prend la premiere paire de slide (slides a,b) et on ajoute cherche la paire de slides qui connecte (slides b,c)
        // On vire ensuite les paire de slides (a,*) et (b,*)
        for (int i = 0; i < len(slidesPair); i++) {
            presentation.addSlide(slidesPair[i][0]);
            presentation.addSlide(slidesPair[i][1]);

            // Ajouter premiere slide trouvée qui commence par la slidesPair[i][1] (slide de droite)
            for (int j = 0; j < len(slidesPair); j++) {
                if (slidesPair[j][0] == slidesPair[i][1]) {
                    presentation.addSlide(slidesPair[j][0]);
                    presentation.addSlide(slidesPair[j][1]);
                }
            }

            // remove slidesPair (i, *), (j, *), (*, i), (*, j)
        }
    }
}
