  new BackgroundExecutor(){
           @Override
           public void onPreExecute() {
               Log.d(TAG, "onPreExecute: ThreadName->"+Thread.currentThread().getName());
           }

           @Override
           public void doInBackground() {
               Log.d(TAG, "doInBackground: ThreadName->"+Thread.currentThread().getName()+" Background Task Executing");
           }


           @Override
           public void postExecute() {
               Log.d(TAG, "postExecute: ThreadName->"+Thread.currentThread().getName());
           }
       }.execute();
