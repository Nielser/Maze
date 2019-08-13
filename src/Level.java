
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Level {

    public int width;
    public int height;

    public Tile[][] tiles;
    public ArrayList<Enemy> enemies;

    public Level() {
       enemies = new ArrayList<>();
        try {
            String levelString = "1111111111111111111111111130100000000014111111100110110111111101000000000111001000001000111101111011101101111111011000000101110410000010001101011010111011111101011110101101031100000000100001010000111111011111011110101111000011101100001110010001111101100010111111011110000010110101010001000111011101011000101010100000001110101111110101010001110000010110000010001111111011111011011111011110130101000001101110000000011010101110110001101111101101010100011110110100000110101011111111000010111111010100000120001101011014001011111011010110100001110100000101101011011110000010111010910000000000011111000001111111111111111111111111111";
            char[] pixelChar = levelString.toCharArray();
            System.out.println(pixelChar.length);
            int[] pixelInt = new int[levelString.length()];
            for (int i = 0; i < levelString.length(); i++) {
                pixelInt[i] = (int) pixelChar[i] - 48;
            }

            this.width = 25;
            this.height = 25;

            tiles = new Tile[width][height];


            for (int xx = 0; xx < width; xx++) {
                for (int yy = 0; yy < height; yy++) {
                    int value = pixelInt[xx + (yy * width)];

                    if (value == 1) {
                        //Tile
                        tiles[xx][yy] = new Tile(xx * 30, yy * 30);
                        //player
                    } else if (value == 2) {
                        Game.player.x = xx * 30;
                        Game.player.y = yy * 30;
                    } else if (value == 3) {
                        enemies.add(new Enemy(xx * 30, yy * 30));
                    } else {
                        //Weg
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).tick();}
        }

        public void render(Graphics g){
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (tiles[x][y] != null) tiles[x][y].render(g);
                }
            }

            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).render(g);
            }
        }
    }

