package week11;

public class Sound {
   /** the array of values in this sound; guaranteed not to be null */
   private int[] samples = { 0, 0, 0, 0, 4, 5, 6, 7, 9, 9, 0 };

   /**
    * Changes those values in this sound that have an amplitude greater than limit.
    * Values greater than limit are changed to limit. Values less than -limit are
    * changed to -limit.
    * 
    * @param limit the amplitude limit Precondition: limit ≥ 0
    * @return the number of values in this sound that this method changed
    */
   public int limitAmplitude(int limit) {
      int numChanges = 0;
      for (int i = 0; i < samples.length; i++) {

         if (samples[i] > limit) {
            samples[i] = limit;
            numChanges++;
         } else if (samples[i] < -limit) {
            samples[i] = -limit;
            numChanges++;
         }
      }

      return numChanges;
   }

   /**
    * Removes all silence from the beginning of this sound. Silence is represented
    * by a value of 0. Precondition: samples contains at least one nonzero value
    * Postcondition: the length of samples reflects the removal of starting silence
    */
   public void trimSilenceFromBeginning() {
      int numSilent = 0;
      while (samples[numSilent] == 0) {
         numSilent++;
      }

      int[] temp = new int[samples.length - numSilent];

      for (int i = 0; i < temp.length; i++) {
         temp[i] = samples[i + numSilent];
      }

      samples = temp;

   }

}
