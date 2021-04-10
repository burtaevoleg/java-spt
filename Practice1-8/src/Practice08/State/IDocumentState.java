package Practice08.State;

public interface IDocumentState {
    String getStatusName();
    void nextDocumStatus(DocumentContext documentContext);
    void previousDocumStatus(DocumentContext documentContext);
}
