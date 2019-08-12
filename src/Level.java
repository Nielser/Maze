
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Level {

    public int width;
    public int height;

    public Tile[][] tiles;
   // public List <Enemy> enemies;

    public Level() {
       // enemies = new ArrayList<>();
        try {
            String levelString = "1111111111111111111111111111111111111111111111111111100000000000001011111001110111111111110100000101111011000000111011111000111101101111011100000111011110000111101110111011101111111111110111011101000111111111111011101110101111111000010000010111000011111101101000001011101101111110110100500100000100111100011000000011111111011110111111000001100001001111000110111111110110110111111011011111111001001011111101100000000010101100111110111110111101010111111111000000011010101000011111111111101101010101111111111111110110011010111111111000000011110001000011111101111100001011111101111110100000110001100000111111211111111111111111111";
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
                        tiles[xx][yy] = new Tile(xx * 50, yy * 50);
                        //player
                    } else if (value == 2) {
                        Game.player.x = xx * 50;
                        Game.player.y = yy * 50;
                    } else if (value == 3) {
                        //enemies.add(new Enemy(xx * 50, yy * 50));
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
       // for (int i = 0; i < enemies.size(); i++) {
      //      enemies.get(i).tick();
        }

        public void render(Graphics g){
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (tiles[x][y] != null) tiles[x][y].render(g);
                }
            }

            //for (int i = 0; i < enemies.size(); i++) {
            //    enemies.get(i).render(g);
           // }
        }
    }

