package tj.mirboboev.challenges;

import java.util.*;

/**
 * Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
 * Output: ["home","about","career"]
 * Explanation:
 * The tuples in this example are:
 * ["joe", 1, "home"]
 * ["joe", 2, "about"]
 * ["joe", 3, "career"]
 * ["james", 4, "home"]
 * ["james", 5, "cart"]
 * ["james", 6, "maps"]
 * ["james", 7, "home"]
 * ["mary", 8, "home"]
 * ["mary", 9, "about"]
 * ["mary", 10, "career"]
 * The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
 * The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
 * The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
 * The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
 * The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
 *
 *
 * ["zkiikgv","zkiikgv","zkiikgv","zkiikgv"]
 * [436363475,710406388,386655081,797150921]
 * ["wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"]
 */

public class AnalyzeUserWebsiteVisitPattern {
    public static void main(String[] args) {
        System.out.println(new AnalyzeUserWebsiteVisitPattern().mostVisitedPattern(
                new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"},
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"}
        ));
        System.out.println(new AnalyzeUserWebsiteVisitPattern().mostVisitedPattern(
                new String[]{"zkiikgv","zkiikgv","zkiikgv","zkiikgv"},
                new int[]{436363475,710406388,386655081,797150921},
                new String[]{"wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"}
        ));
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<String>> usersVisitedWebsitesByTime = usersVisitedWebsites(username, timestamp, website);
        Map<WebsiteSequence, Set<String>> sequenceUsers = sequenceUsers(usersVisitedWebsitesByTime);

        List<WebsiteSequence> sequenceList = new ArrayList<>(sequenceUsers.keySet());

        WebsiteSequence sequence = sequenceList.get(0);


        for (WebsiteSequence websiteSequence : sequenceList) {
            if (sequenceUsers.get(websiteSequence).size() > sequenceUsers.get(sequence).size()) {
                sequence = websiteSequence;
            } else if (sequenceUsers.get(websiteSequence).size() == sequenceUsers.get(sequence).size()) {
                if (websiteSequence.toString().compareTo(sequence.toString()) == -1) {
                    sequence = websiteSequence;
                }
            }
        }

        return Arrays.asList(sequence.website1, sequence.website2, sequence.website3);
    }

    public static Map<String, List<String>> usersVisitedWebsites(String[] username, int[] timestamp, String[] website) {
        Map<Integer, UserVisitedWebsite> timeVisitedWebsites = new HashMap<>();
        Map<String, List<String>> userVisitedWebsites = new HashMap<>();

        for (int i = 0; i < timestamp.length; i++) {
            timeVisitedWebsites.put(timestamp[i], new UserVisitedWebsite(username[i], website[i]));
        }

        Arrays.sort(timestamp);

        for (int time : timestamp) {
            UserVisitedWebsite uvw = timeVisitedWebsites.get(time);
            List<String> userWebsites = userVisitedWebsites.getOrDefault(uvw.user, new ArrayList<>());
            userWebsites.add(uvw.website);
            userVisitedWebsites.put(uvw.user, userWebsites);
        }

        return userVisitedWebsites;
    }

    public static Map<WebsiteSequence, Set<String>> sequenceUsers(Map<String, List<String>> usersVisitedWebsites) {
        Map<WebsiteSequence, Set<String>> sequenceSetMap = new HashMap<>();

        for (String user : usersVisitedWebsites.keySet()) {
            int i = 0;
            List<String> userWebsites = usersVisitedWebsites.get(user);

            while (i < userWebsites.size() - 2) {
                WebsiteSequence sequence = new WebsiteSequence(
                        userWebsites.get(i),
                        userWebsites.get(i + 1),
                        userWebsites.get(i + 2)
                );

                Set<String> sequenceUsers = sequenceSetMap.getOrDefault(sequence, new HashSet<>());
                sequenceUsers.add(user);
                sequenceSetMap.put(sequence, sequenceUsers);

                i += 1;
            }
        }

        return sequenceSetMap;
    }

    public static class UserVisitedWebsite {
        String user;
        String website;

        public UserVisitedWebsite(String user, String website) {
            this.user = user;
            this.website = website;
        }
    }

    public static class WebsiteSequence {
        String website1;
        String website2;
        String website3;

        public WebsiteSequence(String website1, String website2, String website3) {
            this.website1 = website1;
            this.website2 = website2;
            this.website3 = website3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WebsiteSequence sequence = (WebsiteSequence) o;
            return website1.equals(sequence.website1) &&
                    website2.equals(sequence.website2) &&
                    website3.equals(sequence.website3);
        }

        @Override
        public int hashCode() {
            return Objects.hash(website1, website2, website3);
        }

        @Override
        public String toString() {
            return "WebsiteSequence{" +
                    "website1='" + website1 + '\'' +
                    ", website2='" + website2 + '\'' +
                    ", website3='" + website3 + '\'' +
                    '}';
        }
    }
}
