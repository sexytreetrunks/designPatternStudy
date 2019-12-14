package BuilderPtn;

import javax.swing.JFrame;

public class BuilderEx {
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }
        String arg = args[0];
        if ("plain".equals(arg)) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);
        } else if ("html".equals(arg)) {
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String filename = htmlBuilder.getResult();
            System.out.println(filename + "가 작성됨.");
        } else if ("frame".equals(arg)) {
            FrameBuilder frameBuilder = new FrameBuilder();
            Director director = new Director(frameBuilder);
            director.construct();
            JFrame frame = frameBuilder.getResult();
            frame.setVisible(true);
        } else {
            usage();
            System.exit(0);
        }
    }

    public static void usage() {
        System.out.println("Usage: java Main plain (일반텍스트로 문서작성)");
        System.out.println("Usage: java Main html (html파일로 문서작성)");
    }
}
