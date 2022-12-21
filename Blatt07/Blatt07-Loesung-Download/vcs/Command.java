public sealed abstract class Command permits ListFiles,Exit {

    private VCS vcs;

    public Command(VCS vcs) {
        this.vcs = vcs;
    }

    public abstract void execute();

    public VCS getVCS() {
        return vcs;
    }

    public static Command parse(String cmdName, VCS vcs) {
        return switch (cmdName) {
            case "commit" ->  new  Commit(vcs);
            case "listfiles" ->  new ListFiles(vcs);
            case "exit" ->  new Exit(vcs);
            default->{ System.out.println("unknown command " + cmdName);
                yield null;}
        };
    }
}
