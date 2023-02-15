/*
 * Copyright 2023 Code Intelligence GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.code_intelligence.jazzer.mutation.api;

import com.google.errorprone.annotations.DoNotMock;
import java.util.List;

@DoNotMock("Use TestSupport#mockPseudoRandom instead")
public interface PseudoRandom {
  /**
   * @return a uniformly random {@code boolean}
   */
  boolean choice();

  /**
   * @return a {@code boolean} that is {@code true} with probability {@code 1/inverseFrequencyTrue}
   */
  boolean trueInOneOutOf(int inverseFrequencyTrue);

  /**
   * @throws IllegalArgumentException if {@code array.length == 0}
   * @return a uniformly random index valid for the given array
   */
  <T> int indexIn(T[] array);

  /**
   * @throws IllegalArgumentException if {@code list.size() == 0}
   * @return a uniformly random index valid for the given list
   */

  <T> int indexIn(List<T> list);

  /**
   * Prefer {@link #indexIn(Object[])} and {@link #indexIn(List)}.
   *
   * @throws IllegalArgumentException if {@code range < 1}
   * @return a uniformly random index in the range {@code [0, range-1]}
   */
  int indexIn(int range);

  /**
   * @throws IllegalArgumentException if {@code array.length < 2}
   * @return a uniformly random index valid for the given array and different from
   * {@code currentIndex}
   */
  <T> int otherIndex(T[] array, int currentIndex);

  /**
   * @return a uniformly random {@code int} in the closed range
   * {@code [lowerInclusive, upperInclusive]}.
   */
  int closedRange(int lowerInclusive, int upperInclusive);

  /**
   * @return a uniformly random {@code long} in the closed range
   * {@code [lowerInclusive, upperInclusive]}.
   */
  long closedRange(long lowerInclusive, long upperInclusive);
}