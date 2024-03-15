/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package musicapp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JOptionPane;


public class MusicGUI extends javax.swing.JFrame {
    
    
    private Stack<String> likedSongs;
    private Stack<String> electroSongs;
    private Stack<String> rockSongs;
    
    private enum PlaylistType {LIKED, ELECTRO, ROCK}
    
    private PlaylistType currentPlaylistType;
    
    public Stack<String> getLikedSongs() {
        return likedSongs;
    }
    
    public Stack<String> getElectroList() {
        return electroSongs;
    }
   
        
    // Define a Queue to store the playlist songs
    private Queue<String> playlistQueue = new LinkedList<>();

    // Method to add songs to the playlist queue
    private void addToPlaylistQueue(String songName) {
        playlistQueue.add(songName);
}
    
    // Define variables to track the current index of the song being played in each playlist
    private int electroIndex = 0;
    private int rockIndex = 0;
    private int likedIndex = 0;
    
    // Define a boolean variable to track repeat mode
    private boolean isRepeatMode = false;
    
    // Constructor and other GUI-related methods...
    
    // Method to add songs from a stack to the playlist queue
    private void addToPlaylistQueue(Stack<String> songStack) {
        while (!songStack.isEmpty()) {
            String songName = songStack.pop();
            playlistQueue.add(songName);
        }
    }
    
     private void searchLikedSongs(String query) {
        StringBuilder searchResults = new StringBuilder();
        for (String song : likedSongs) {
            if (song.contains(query)) {
                searchResults.append(song).append("\n");
            }
        }
        // Display search results in the text area
        songBox.setText(searchResults.toString());
    }
    private void playNextSong() {
        switch (currentPlaylistType) {
            case ELECTRO:
                if (electroIndex < electroSongs.size()) {
                    String currentSong = electroSongs.get(electroIndex);
                    System.out.println("Now Playing: " + currentSong);
                    electroIndex++; // Move to the next song
                } else {
                    if (isRepeatMode && !electroSongs.isEmpty()) {
                        electroIndex = 0; // Reset the index to loop back to the beginning
                        playNextSong(); // Play the first song again
                    } else {
                        System.out.println("End of Electro playlist.");
                    }
                }
                break;
            case ROCK:
                if (rockIndex < rockSongs.size()) {
                    String currentSong = rockSongs.get(rockIndex);
                    System.out.println("Now Playing: " + currentSong);
                    rockIndex++; // Move to the next song
                } else {
                    if (isRepeatMode && !rockSongs.isEmpty()) {
                        rockIndex = 0; // Reset the index to loop back to the beginning
                        playNextSong(); // Play the first song again
                    } else {
                        System.out.println("End of Rock playlist.");
                    }
                }
                break;
            case LIKED:
                if (likedIndex < likedSongs.size()) {
                    String currentSong = likedSongs.get(likedIndex);
                    System.out.println("Now Playing: " + currentSong);
                    likedIndex++; // Move to the next song
                } else {
                    if (isRepeatMode && !likedSongs.isEmpty()) {
                        likedIndex = 0; // Reset the index to loop back to the beginning
                        playNextSong(); // Play the first song again
                    } else {
                        System.out.println("End of Liked Songs playlist.");
                    }
                }
                break;
            default:
                System.out.println("Unknown playlist type.");
                break;
        }
    }
    
    // Method to toggle repeat mode
    private void toggleRepeatMode() {
        isRepeatMode = !isRepeatMode; // Toggle the repeat mode flag
        if (isRepeatMode) {
            repeatButton.setText("Repeat: ON"); // Update button label to indicate repeat mode is ON
        } else {
            repeatButton.setText("Repeat: OFF"); // Update button label to indicate repeat mode is OFF
        }
    }
    
    // Method to play the playlist
    private void playPlaylist() {
        switch (currentPlaylistType) {
            case ELECTRO:
                addToPlaylistQueue(electroSongs); // Add songs from Electro stack to queue
                break;
            case ROCK:
                addToPlaylistQueue(rockSongs); // Add songs from Rock stack to queue
                break;
            case LIKED:
                addToPlaylistQueue(likedSongs); // Add songs from Liked stack to queue
                break;
            default:
                return; // Return if an unknown playlist type is encountered
        }
        
        // Now play songs from the playlist queue
        while (!playlistQueue.isEmpty() || isRepeatMode) {
            String currentSong = playlistQueue.poll(); // Dequeue the next song from the queue
            if (currentSong != null) {
                songTitle.setText("Now Playing: " + currentSong);
                // If repeat mode is ON, add the song back to the end of the queue for continuous playback
                if (isRepeatMode) {
                    playlistQueue.add(currentSong);
                }
            } else {
                break; // Break the loop if the queue is empty and repeat mode is OFF
            }
        }
    }

    public MusicGUI(){
        initComponents();
        likedSongs = new Stack<>();
        electroSongs = new Stack<>();
        rockSongs = new Stack<>();
        currentPlaylistType = PlaylistType.LIKED;
        updateSongBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textArea1 = new java.awt.TextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        addToLiked = new javax.swing.JButton();
        songNameText = new javax.swing.JTextField();
        addToElectro = new javax.swing.JButton();
        addToRock = new javax.swing.JButton();
        showRockList = new javax.swing.JButton();
        showElectroList = new javax.swing.JButton();
        songBox = new java.awt.TextArea();
        songCount = new javax.swing.JTextField();
        songTitle = new javax.swing.JTextField();
        showLiked = new javax.swing.JButton();
        removeElectro = new javax.swing.JButton();
        removeRock = new javax.swing.JButton();
        repeatButton = new javax.swing.JButton();
        title = new javax.swing.JTextField();
        playButton = new javax.swing.JButton();
        playNext = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        addToLiked.setText("Add to Liked Songs");
        addToLiked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToLikedActionPerformed(evt);
            }
        });

        songNameText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        songNameText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        songNameText.setText("Add/Search for a Song");

        addToElectro.setText("Add to Electro Playlist");
        addToElectro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToElectroActionPerformed(evt);
            }
        });

        addToRock.setText("Add to Rock Playlist");
        addToRock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToRockActionPerformed(evt);
            }
        });

        showRockList.setText("Show Rock Playlist");
        showRockList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRockListActionPerformed(evt);
            }
        });

        showElectroList.setText("Show Electro Playlist");
        showElectroList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showElectroListActionPerformed(evt);
            }
        });

        songBox.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        songCount.setBackground(new java.awt.Color(51, 51, 51));
        songCount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        songCount.setForeground(new java.awt.Color(255, 255, 255));
        songCount.setText("Song Count: ");
        songCount.setBorder(null);

        songTitle.setBackground(new java.awt.Color(51, 51, 51));
        songTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        songTitle.setForeground(new java.awt.Color(255, 255, 255));
        songTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        songTitle.setBorder(null);

        showLiked.setText("Show Liked Songs");
        showLiked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showLikedActionPerformed(evt);
            }
        });

        removeElectro.setText("Remove from Electro Playlist");
        removeElectro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeElectroActionPerformed(evt);
            }
        });

        removeRock.setText("Remove from Rock Playlist");
        removeRock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRockActionPerformed(evt);
            }
        });

        repeatButton.setText("Repeat");
        repeatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeatButtonActionPerformed(evt);
            }
        });

        title.setBackground(new java.awt.Color(51, 51, 51));
        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        title.setBorder(null);
        title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleActionPerformed(evt);
            }
        });

        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        playNext.setText("Play Next Song");
        playNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playNextActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(repeatButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playNext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(songNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(showLiked, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(addToLiked, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)))
                                .addGap(18, 18, 18)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(songCount, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addToRock, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addToElectro, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showElectroList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showRockList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeElectro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeRock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(songBox, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(songTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playNext, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(repeatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(songNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addToLiked, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showLiked, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(songCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(1, 1, 1)
                .addComponent(songBox, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(songTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addToElectro, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showElectroList, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showRockList, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addToRock, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(removeElectro, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeRock, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addToLikedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToLikedActionPerformed
        String songName = songNameText.getText().trim();
        if (!songName.isEmpty()) {
            title.setText("Liked Songs");
            likedSongs.push(songName);
            System.out.println("Added to Liked Songs: " + songName);
            getLikedSongs();
            addToPlaylist(songName, currentPlaylistType); // Add to respective playlist
            songNameText.setText(""); // Clear text field
            updateSongBox(); // Update display after adding song
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter a song name.");
        }
    }//GEN-LAST:event_addToLikedActionPerformed

    private void addToElectroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToElectroActionPerformed
        if (!likedSongs.isEmpty()) {
            String song = likedSongs.peek();
            title.setText("Electro Playlist");
            electroSongs.push(song);
            updateSongBox();
            getElectroList();
            System.out.println("Added to Electro: " + song);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Liked List is empty.");
        }
    }//GEN-LAST:event_addToElectroActionPerformed

    private void addToRockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToRockActionPerformed
        if (!likedSongs.isEmpty()) {
            String song = likedSongs.peek();
            rockSongs.push(song);
            updateSongBox();
            System.out.println("Added to Rock: " + song);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Liked List is empty.");
        }
    }//GEN-LAST:event_addToRockActionPerformed

    private void showRockListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRockListActionPerformed
        currentPlaylistType = PlaylistType.ROCK;
        updateSongBox();
    }//GEN-LAST:event_showRockListActionPerformed

    private void showElectroListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showElectroListActionPerformed
        currentPlaylistType = PlaylistType.ELECTRO;
        title.setText("Electro Playlist");
        updateSongBox();
    }//GEN-LAST:event_showElectroListActionPerformed

    private void showLikedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showLikedActionPerformed
        currentPlaylistType = PlaylistType.LIKED;
        title.setText("Liked Songs");
        updateSongBox();
    }//GEN-LAST:event_showLikedActionPerformed

    private void removeElectroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeElectroActionPerformed
        if (!electroSongs.isEmpty()) {
            String removedSong = electroSongs.pop();
            title.setText("Electro Playlist");
            updateSongBox();
            System.out.println("Removed from Electro Playlist: " + removedSong);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Electro Playlist is empty.");
        }        
    }//GEN-LAST:event_removeElectroActionPerformed

    private void removeRockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRockActionPerformed
        if (!rockSongs.isEmpty()) {
            String removedSong = rockSongs.pop();
            title.setText("Rock Playlist");
            updateSongBox();
            System.out.println("Removed from Rock Playlist: " + removedSong);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Rock Playlist is empty.");
        }        
    }//GEN-LAST:event_removeRockActionPerformed

    private void repeatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repeatButtonActionPerformed
        toggleRepeatMode();
    }//GEN-LAST:event_repeatButtonActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        playPlaylist();
    }//GEN-LAST:event_playButtonActionPerformed

    private void playNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playNextActionPerformed
        playNextSong();
    }//GEN-LAST:event_playNextActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String query = songNameText.getText().trim();
        if (!query.isEmpty()) {
            searchLikedSongs(query);
            title.setText("Search Results");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a search query.");
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleActionPerformed

    
    private void addToPlaylist(String songName, PlaylistType currentPlaylistType) {
        switch (currentPlaylistType) {
            case ELECTRO:
                electroSongs.push(songName);
                break;
            case ROCK:
                rockSongs.push(songName);
                break;
        }
    }

    private void updateSongBox() {
        StringBuilder sb = new StringBuilder();
        switch (currentPlaylistType) {
            case LIKED:
                title.setText("Liked Songs");
                for (String song : likedSongs) {
                    sb.append(song).append("\n");
                }
                songCount.setText(likedSongs.size() + " Songs");
                break;
            case ELECTRO:
                title.setText("Electro Playlist");
                for (String song : electroSongs) {
                    sb.append(song).append("\n");
                }
                songCount.setText(electroSongs.size() + " Songs");
                break;
            case ROCK:
                title.setText("Rock Playlist");
                for (String song : rockSongs) {
                    sb.append(song).append("\n");
                }
                songCount.setText(rockSongs.size() + " Songs");
                break;
        }
        songBox.setText(sb.toString());
    }
        
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MusicGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusicGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusicGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusicGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MusicGUI().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToElectro;
    private javax.swing.JButton addToLiked;
    private javax.swing.JButton addToRock;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton playButton;
    private javax.swing.JButton playNext;
    private javax.swing.JButton removeElectro;
    private javax.swing.JButton removeRock;
    private javax.swing.JButton repeatButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton showElectroList;
    private javax.swing.JButton showLiked;
    private javax.swing.JButton showRockList;
    private java.awt.TextArea songBox;
    private javax.swing.JTextField songCount;
    private javax.swing.JTextField songNameText;
    private javax.swing.JTextField songTitle;
    private java.awt.TextArea textArea1;
    private javax.swing.JTextField title;
    // End of variables declaration//GEN-END:variables
}
