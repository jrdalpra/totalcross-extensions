package com.wolkenapps.totalcross.utils.ui;

import totalcross.io.IOException;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class Images {

   public static Image create(String path) {
      try {
         return new Image(path);
      } catch (ImageException e) {
         throw new RuntimeException(e.getMessage());
      } catch (IOException e) {
         throw new RuntimeException(e.getMessage());
      }
   }

   public static Image[] create(String[] paths) {
      Image[] images = new Image[paths.length];
      for (int each = 0, length = paths.length; each < length; each++) {
         images[each] = create(paths[each]);
      }
      return images;
   }

}
