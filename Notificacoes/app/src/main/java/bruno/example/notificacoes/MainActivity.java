package bruno.example.notificacoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnnoti1Prog = (Button) findViewById(R.id.btnnoti1);
        Button btnnoti2Prog = (Button) findViewById(R.id.btnnoti2);

        btnnoti1Prog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mensagem = "50% de desconto.";
                String titulo = "Promoção!";
                notificarUsuario (mensagem, titulo);
            }

            private void notificarUsuario (String mensagem, String titulo) {
                NotificationCompat.Builder notificacao = new NotificationCompat.Builder(getBaseContext());
                notificacao.setContentTitle(titulo);
                notificacao.setContentText(mensagem);
                notificacao.setPriority(Notification.PRIORITY_HIGH);
                notificacao.setSmallIcon(R.drawable.ic_launcher_foreground);
                notificacao.setAutoCancel(true);
                Intent it = new Intent(getBaseContext(), promocao.class);

                PendingIntent pit = PendingIntent.getActivity(getBaseContext(), 100, it, PendingIntent.FLAG_UPDATE_CURRENT);
                notificacao.setContentIntent(pit);

                NotificationManager notificar = (NotificationManager)
                getBaseContext() .getSystemService(Context.NOTIFICATION_SERVICE);
                notificar.notify(9000, notificacao.build());
            }
        });

        btnnoti2Prog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mensagem = "25% de desconto.";
                String titulo = "Promoção!";
                notificarUsuario (mensagem, titulo);
            }

            private void notificarUsuario (String mensagem, String titulo) {
                NotificationCompat.Builder notificacao = new NotificationCompat.Builder(getBaseContext());
                notificacao.setContentTitle(titulo);
                notificacao.setContentText(mensagem);
                notificacao.setPriority(Notification.PRIORITY_HIGH);
                notificacao.setSmallIcon(R.drawable.ic_launcher_foreground);
                notificacao.setAutoCancel(true);
                Intent it = new Intent(getBaseContext(), promocao2.class);

                PendingIntent pit = PendingIntent.getActivity(getBaseContext(), 100, it, PendingIntent.FLAG_UPDATE_CURRENT);
                notificacao.setContentIntent(pit);

                NotificationManager notificar = (NotificationManager)
                        getBaseContext() .getSystemService(Context.NOTIFICATION_SERVICE);
                notificar.notify(8000, notificacao.build());
            }
        });
    }
}