package pl.dixu.client;

import pl.dixu.server.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener {

    private SwingPresenter swingPresenter;

    public MouseManager(SwingPresenter swingPresenter) {
        this.swingPresenter = swingPresenter;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        swingPresenter.click(new Point(e.getX(),e.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
