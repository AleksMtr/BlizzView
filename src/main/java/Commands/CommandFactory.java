package Commands;

public class CommandFactory {

    public Command createCommand(String action) {
        switch (action) {
            case "login":
                return new LoginCommand();
            case "register":
                return new RegisterCommand();
            case "viewChar":
                return new ViewCharCommand();
            case "compare":
                return new CompareCommand();
            case "postArticle":
                return new PostArticleCommand();
            case "deleteArticle":
                return new DeleteArticleCommand();
            case "postComment":
                return new PostCommentCommand();
            case "deleteComment":
                return new DeleteCommentCommand();
            case "editArticle":
                return new EditArtCommand();
            case "editArt":
                return new EditArticleCommand();
            case "editComm":
                return new EditCommCommand();
            case "editComment":
                return new EditCommentCommand();
            case "editUser":
                return new EditUserCommand();
            case "editPasswd":
                return new ChangePasswordCommand();
            case "assignMain":
                return new AssignMainCommand();
            case "deleteUser":
                return new DeleteUserCommand();
            default:
                break;
        }

        return null;
    }
}
