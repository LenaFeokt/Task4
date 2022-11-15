package model;

import javafx.scene.image.Image;

public class ImageCollection {
    private Image bi;
    private class ImageIterator implements Iterator {
        private int current = 0;

        @Override
        public boolean hasNext() {
            String filename = "/" + (current + 1) + ".BMP";
            System.out.println(filename);
            try {
                bi = new Image(filename);
                return true;
            } catch (Exception ex) {
                current = 0;
                bi = new Image("/" + (current + 1) + ".BMP");
                return true;
            }
        }

        @Override
        public Object next() {
            current++;
            return bi;
        }

        public boolean hasPreview(){
            String filename = null;
            System.out.println(current);
            if(current >= 2) {
                filename = "/" + (current - 1) + ".BMP";
            }
            System.out.println(filename);
            try {
                bi = new Image(filename);
                return true;
            } catch (Exception ex) {
                System.err.println("Не удалось загрузить картинку! " + filename);
                return false;
            }
        }

        @Override
        public Object preview() {
            current--;
            return bi;
        }
    }


    public Iterator getIterator() {
        return new ImageIterator();
    }
}
