package card;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/*

Deco ImageView 이동, 줌 관련 TouchListener 입니다

 */

// 참고 사이트
// https://judepereira.com/blog/multi-touch-in-android-translate-scale-and-rotate/


public class Card01_TouchListener implements View.OnTouchListener{

    // 3가지 상태
    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;

    // 터치 모드
    int mode = NONE;

    // ZOOM 모드 시 필요한 자원
    private float oldDist;
    private float newDist;
    float oldX;
    float oldY;
    float oldDecoX;
    float oldDecoY;


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView decoView = (ImageView) view;

        switch(motionEvent.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                // 터치 했을 때
                mode = DRAG;
                oldX = motionEvent.getRawX();
                oldY = motionEvent.getRawY();
                oldDecoX = decoView.getX();
                oldDecoY = decoView.getY();
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                // 두 손가락 터치 했을 때
                oldDist = getDistance(motionEvent);
                mode = ZOOM;
                break;

            // 손 떼는 동작
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                mode = NONE;
                break;

            // 움직이는 동작
            case MotionEvent.ACTION_MOVE:
                if(mode == DRAG){
                    // 드래그(이동)
                    decoView.setX(motionEvent.getRawX() - oldX + oldDecoX);
                    decoView.setY(motionEvent.getRawY() - oldY + oldDecoY);

                } else if (mode == ZOOM) {
                    // 줌
                    newDist = getDistance(motionEvent);
                    float scale = (newDist / oldDist);
                    decoView.setScaleX(scale);
                    decoView.setScaleY(scale);
                }
                break;
        }
        return true;
    }

    private float getDistance(MotionEvent e){
        float dx = e.getX(1) - e.getX(0);
        float dy = e.getY(1) - e.getY(0);

        return (float) (Math.sqrt(dx * dx + dy * dy));
    }
}
