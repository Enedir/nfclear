package nf.clear.application.usecase;

import nf.clear.application.presenter.Presenter;

public interface Usecase<I> {
    <T> T execute (I input, Presenter present);
}
