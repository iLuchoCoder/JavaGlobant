public class Ej1 {

    private int[] wall = new int[] {3,4,2,4,2};

    public static void main(String[] args) {
        Ej1 ej1 = new Ej1();

        System.out.println(ej1.blocksAmount());

        int blockAmount = ej1.blocksAmount();
        int avg = ej1.getAvg(blockAmount);

        System.out.println(avg);
        System.out.println(ej1.wallSize(avg));
        System.out.println(ej1.equalizer());
    }

    public int blocksAmount() {
        int blockAmount = 0;
        for (int i = 0; i < wall.length; i++){
            blockAmount += wall[i];
        }
        return blockAmount;
    }

    public int getAvg(int blockAmount) {
        return blockAmount / wall.length;
    }

    public int wallSize(int blockAvg) {
        int blocksToMove = 0;
        for (int i = 0 ; i < wall.length; i++) {
            if (wall[i] > blockAvg) {
                blocksToMove = blocksToMove + (wall[i] - blockAvg);
            }
        }
        return blocksToMove;
    }

    public int equalizer() {
        int maxBloq = 0;
        int blocksToEqual = 0;
        for (int i = 0 ; i < wall.length; i++) {
            if (wall[i] > maxBloq) {
                maxBloq = wall[i];
            }
        }

        for (int i = 0 ; i < wall.length; i++) {
            if (wall[i] < maxBloq) {
                blocksToEqual += maxBloq - wall[i];
            }
        }
        return blocksToEqual;
    }
}