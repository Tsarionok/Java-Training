package by.tsarionok.page;

public class PageManager {

    public static PageEnum definePage(final String uri) {
        PageEnum[] pages = PageEnum.values();
        for (PageEnum pageEnum : pages) {
            if (pageEnum.getPageUri().equals(uri)) {
                return pageEnum;
            }
        }
        return null;
    }

    public static JspPage createPage(String uri) {
        PageEnum pageEnum = definePage(uri);
        if (pageEnum != null) {
            return new JspPage(pageEnum.getPageUri(), pageEnum.getAllowRoles());
        }
        return null;
    }
}
