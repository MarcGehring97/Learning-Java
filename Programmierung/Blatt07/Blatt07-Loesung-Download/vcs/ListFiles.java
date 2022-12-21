public non-sealed class ListFiles extends Command {

    public ListFiles(VCS vcs) {
        super(vcs);
    }

    @Override
    public void execute() {
        for (String file: Util.listFiles(getVCS().getRootDir())) {
            System.out.println(file);
        }
    }

}
