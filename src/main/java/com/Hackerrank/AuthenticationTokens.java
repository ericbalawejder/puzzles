package com.Hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/discuss/interview-question/378237/Twitter-or-OA-2019-or-Authentication-Tokens

Twitter users log in and stay authenticated. This keeps them from having to log in repeatedly.
You can image that this authentication works by using authentication tokens. Each token has an
expiry , denoted by expiryLimit. Each token expires automatically after expiryLimit minutes
pass after it was last reset. When reset, the expiry time is reset to expiryLimit minutes
from the time of reset.

1. A token can be reset any number of times.
2. Once a token expires, it can no longer be accessed and a reset issued to it will be ignored.
3. A reset issued to a non-existent token is also ignored.

Commands:
Get command - syntax: Get token_id T
    Generates a token token_id at time T. Only one get token per token_id is possible.
Reset command - syntax: Reset token_id T
    Resets the token token_id at time T.

Note:
Get is represented by 0 and Reset by 1.
The current time, in the end, is the maximum time of all commands.

Given a sequence of commands with no pre-existing tokens, and these commands sorted ascending
by their T parameter, find the number of tokens that are active just after all commands have
been executed.

For example, given expiryLimit = 4, each time a token is created or reset, its new expiration time
will be at time T + 4. The list of commands = [[0, 1, 1], [0, 2, 2], [1, 1, 5], [1, 2, 7]].
The first command [0, 1, 1] means get a new token with token_id = 1 at time T = 1 and set its expiry to
T + expiryLimit = 5. The next command similarly creates token_id = 2 with an expiry with T = 6. A reset
command comes in for token_id = 1 at T = 5 which is within the expiry limit so a new limit is set
5 + 4 = 9. token_id = 2 expires at time T = 6, so when the Reset token_id = 2 command comes in at T = 7,
it is ignored. Only token_id = 1 is active at time T = 7.

Function description:

Complete the numberOfTokens() function. The function must return and integer that denotes the number
of tokens that exist at the end of the command stream.

numberOfTokens() has the following parameters.
    expiryLimit: An integer that denotes the expiry limit of each token.
    commands[commands[0], [commandsn - 1]] A 2-D integer array where each row, commands[i] has 3
    integers [command, token_id, T].

Constraints:
    1 <= expiryLimit <= 10^8
    1 <= n <= 10^5
    1 <= token_id <= 10^8
    1 <= T <= 10^8

 */
public class AuthenticationTokens {

    public static void main(String[] args) {

    }

    public static int numberOfTokens(int expiryLimit, List<List<Integer>> commands) {
        if (commands == null || commands.isEmpty()) {
            throw new IllegalArgumentException("No commands");
        }
        //maintain tokenid with expiry in a map
        final Map<Integer, Integer> tokenIdToTokenExpiry = new HashMap<>();

        for (List<Integer> token : commands) {
            if (token.size() != 3) {
                return 0;
            }
            //tokenCommand can be either 0 (get) or 1 (reset)
            Integer tokenCommand = token.get(0);
            Integer tokenId = token.get(1);
            Integer tokenTime = token.get(2);

            if (tokenCommand == 0) {
                // Get command
                tokenIdToTokenExpiry.put(tokenId, tokenTime + expiryLimit);
            } else {
                //Reset command
                if (tokenIdToTokenExpiry.containsKey(tokenId)) {
                    if (tokenTime <= tokenIdToTokenExpiry.get(tokenId)) {
                        //If not expired, update token time with new value
                        tokenIdToTokenExpiry.put(tokenId, tokenTime + expiryLimit);
                    } else {
                        //if expired, remove token from map
                        tokenIdToTokenExpiry.remove(tokenId);
                    }
                }
            }
        }
        //find the last inputed tokentime and filter data based on expiry
        Integer lastTime = commands.get(commands.size() - 1).get(2);
        return (int) tokenIdToTokenExpiry.values().stream().filter(tokenTime -> tokenTime >= lastTime).count();
    }

    public static int numberOfTokens(int exp, int[][] commands) {
        Map<Integer, Integer> set = new HashMap<>();
        for (int[] token : commands) {
            if (token[0] == 1) {
                if (set.containsKey(token[1])) {
                    if (token[2] > set.get(token[1])) {
                        set.remove(token[1]);
                    } else {
                        set.put(token[1], token[2] + exp);
                    }
                }
            } else {
                set.put(token[1], token[2] + exp);
            }
        }
        return set.size();
    }

}
